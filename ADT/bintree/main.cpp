#include <iostream>
#include "binnode.h"
#include "bintree.h"

void (*visit) (int data);

void print(int data){
    std::cout << data << std::endl;
}

int main() {
	visit = print;

	{
//		BinNodePosi(int) node = new BinNode<int>(1);
//		BinNodePosi(int) l2l = node->insertAsLC(2);
//		BinNodePosi(int) l2r = node->insertAsRC(3);
//		l2l->insertAsLC(4);
//		l2l->insertAsRC(5);
//		l2r->insertAsLC(6);
//		l2r->insertAsRC(7);
//
//		node->travPre(visit);
//		std::cout << "--------------------------" << std::endl;
//
//		node->travIn(visit);
	}

	{
	    BinTree<int> * tree = new BinTree<int>();
	    BinNodePosi(int) root = tree->insertAsRoot(1);
	    BinNodePosi(int) l2l = tree->insertAsLC(root,2);
	    BinNodePosi(int) l3lr = tree->insertAsRC(l2l,3);

	    BinTree<int> * tree2 = new BinTree<int>();
	    BinNodePosi(int) tree2_root = tree2->insertAsRoot(4);
	    BinNodePosi(int) tree2_l2r = tree2->insertAsRC(tree2_root,5);
	    BinNodePosi(int) tree2_l3rl = tree2->insertAsLC(tree2_l2r,6);

	    tree->attachAsRC(root,tree2);

	    tree->travIn(visit);

		std::cout <<  "--------------------"   << std::endl;
		std::cout << tree2_l3rl->succ()->data << std::endl;
		std::cout <<  "--------------------"   << std::endl;
	    std::cout <<  tree->size()   << std::endl;
		std::cout <<  "--------------------"   << std::endl;
	    std::cout <<  root->get_height()   << std::endl;
	}


    {
//        BinTree<int> tree1;
//        BinNodePosi(int) root = tree1.insertAsRoot(1);
//        BinNodePosi(int) l2l = tree1.insertAsLC(root,2);
//        tree1.insertAsLC(l2l,3);
//        tree1.travIn(visit);
    }


    return 0;
}
