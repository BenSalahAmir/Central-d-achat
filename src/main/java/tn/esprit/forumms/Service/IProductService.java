package tn.esprit.forumms.Service;

import tn.esprit.forumms.Entity.Product;

public interface IProductService{

    public Product addProduct(Product product,long idUser,long idcomment);
}
