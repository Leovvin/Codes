/*
 * =====================================================================================
 *
 *       Filename:  release.h
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  01/23/2019 02:38:24 PM
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Leo, 
 *   Organization:  
 *
 * =====================================================================================
 */


template <typename T> void release(T* t){
    if(t) delete t;
}
