package tn.esprit.forumms.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.forumms.Entity.CommentPost;
import tn.esprit.forumms.Entity.Post;
import tn.esprit.forumms.Entity.Product;
import tn.esprit.forumms.Entity.User;
import tn.esprit.forumms.Repository.CommentPostRepository;
import tn.esprit.forumms.Repository.PostRepository;
import tn.esprit.forumms.Repository.ProductRepository;
import tn.esprit.forumms.Repository.UserRepository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
@Slf4j
public class ICommentPostServiceImp implements ICommentPostService{
    public final CommentPostRepository commentPostRepository;
    public final UserRepository userRepository;
    public final PostRepository postRepository;
    public final ProductRepository productRepository;




    @Override
    public List<CommentPost> getAllComments() {
        return commentPostRepository.findAll();
    }

    private List<String> fetchBadWords() {
        List<String> badWords = new ArrayList<>();
        try {
            URL url = new URL("https://docs.google.com/spreadsheets/d/1hIEi2YG3ydav1E06Bzf2mQbGZ12kh2fe4ISgLg_UBuM/export?format=csv");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 0) {
                    badWords.add(values[0]);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return badWords;
    }

    public String convertEmoticonsToEmoji(String text) {
        Map<String, String> emoticonMap = new HashMap<>();
        emoticonMap.put(":)", "\uD83D\uDE42");
        emoticonMap.put(":(", "\uD83D\uDE41");
        emoticonMap.put(":D", "\uD83D\uDE00");
        emoticonMap.put(":P", "\uD83D\uDE1B");

        for (Map.Entry<String, String> entry : emoticonMap.entrySet()) {
            String pattern = Pattern.quote(entry.getKey()); // escape any special characters
            text = text.replaceAll(pattern, entry.getValue());
        }

        return text;
    }

    @Override
    public CommentPost addComment(CommentPost commentPost,Long idUser,Long idPost) {
        User user=userRepository.findById(idUser).orElse(null);
        Post post=postRepository.findById(idPost).orElse(null);
        commentPost.setUserComment(user);
        commentPost.setPost(post);
        String commentTextWithEmoji = convertEmoticonsToEmoji(commentPost.getDescriptionComment());
        commentPost.setDescriptionComment(commentTextWithEmoji);
        List<String> badWords = fetchBadWords();

        boolean containsBadWord = false;
        for (String badWord : badWords) {
            if (commentPost.getDescriptionComment().toLowerCase().contains(badWord.toLowerCase())) {
                containsBadWord = true;
                break;
            }
        }

        if (containsBadWord) {
            return null;
        }
        return commentPostRepository.save(commentPost);
    }

    @Override
    public CommentPost editComment(CommentPost commentPost,Long idUser) {
        User user=userRepository.findById(idUser).orElse(null);
        if (commentPost.getUserComment().equals(user))
        return commentPostRepository.save(commentPost);
        else
            return null;
    }

    @Override
    public void deleteComment(Long commentId,Long idUser) {
        User user=userRepository.findById(idUser).orElse(null);
        if (commentPostRepository.findById(commentId).orElse(null).getUserComment().equals(user))
        commentPostRepository.deleteById(commentId);
    }

    @Override
    public CommentPost getById(Long commentId) {
        return commentPostRepository.findById(commentId).orElse(null);
    }

    @Override
    public CommentPost setProductToComment(Long commentId, Long idProduct) {
        Product product=productRepository.findById(idProduct).orElse(null);
        CommentPost comment=commentPostRepository.findById(commentId).orElse(null);
        comment.setProductForum(product);
        return commentPostRepository.save(comment);
    }


}
