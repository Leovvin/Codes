//
// Created by Leo on 2019-01-19.
//

#ifndef BINTREE_BINNODE_MACRO_BASIC_H
#define BINTREE_BINNODE_MACRO_BASIC_H

#define IsRoot(x) ( ! ( (x).parent ) )
#define IsLChild(x) ( ! IsRoot(x) && ( & (x) == (x).parent->lc ) )
#define IsRChild(x) ( ! IsRoot(x) && ( & (x) == (x).parent->rc ) )
#define HasParent(x) ( ! IsRoot(x) )
#define HasLChild(x) ((x).lc)
#define HasRChild(x) ((x).rc)
#define HasChild(x) ( HasLChild(x) || HasRChild(x) )
#define HasBothChild(x) ( HasLChild(x) && HasRChild(x) )
#define IsLeaf(x) ( ! HasChild(x) )

#define FromParentTo(x) ( IsRoot(x) ? _root : ( IsLChild(x) ? (x).parent->lc : (x).parent->rc ) )

#endif //BINTREE_BINNODE_MACRO_BASIC_H
