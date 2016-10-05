#include <iostream>
#include <cmath>
using std::string;

string LCS_recursion(string s1,string s2);

int main() {
    std::cout<<LCS_recursion("program","algorithm")<<std::endl;
    return 0;
}

string LCS_recursion(string s1,string s2){
    if(s1.length()==0 || s2.length()==0){
        return "";
    }
    char c1=s1.at(s1.length()-1);
    char c2=s2.at(s2.length()-1);
    if(c1==c2){
        return LCS_recursion(s1.substr(0,s1.length()-1),s2.substr(0,s2.length()-1))+c1;
    } else{
        string ss1=LCS_recursion(s1.substr(0,s1.length()-1),s2);
        string ss2=LCS_recursion(s1,s2.substr(0,s2.length()-1));
        return ss1.length()>ss2.length()?ss1:ss2;
    }
}