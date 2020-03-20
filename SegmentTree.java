import java.util.Arrays;

public class SegmentTree {//It is implemented as a array heap like in heapsort
    // size of segment tree is 2*n-1 (always odd )for n elements eg.for 3 elements we have 5 elements, for 4-7,for 7-13
    // for size 7 , we keep 8 to 13 for simple [l,l]note same location
    //in this implementation Rmq returns index of min value and not the value
    //another way is to built the n^2 array in n^2 time and give query in o(1) time
    //this implementation of range minimum Query(note ) works for negative values also leaving the Integer.MAX_value
    public static void main(String[] args) {
       int arr[]={18, 17, 13, 19,15,99,15};
       int ret[]=new int[arr.length*2-1];
       built(arr,ret,0,0,6);
        System.out.println(rMin(4,6,arr,ret));//here rMinQ(3,6) returns 15 means 3, 6 both included
    }
    static int left(int t){
        return (t<<1)+1;
    }
    static int right(int t){
        return (t<<1) +2;
    }
    static void built(int arr[],int ret[],int pi,int l,int r)//pi is present index pi,l,r go along always
    {
        if(l==r){ret[pi]=l;
        }
        else{
            built(arr,ret,left(pi),l,(r+l)/2);
            built(arr,ret,right(pi),((r+l)/2)+1,r);
            int pp=ret[left(pi)];
            int ppp=ret[right(pi)];
            int ans=Math.min(arr[pp],arr[ppp])==arr[pp]?pp:ppp;
            ret[pi]=ans;
        }
    }
    static int rMin(int i,int j,int pi,int l,int r,int arr[],int ret[]){//use the overloaded method
        if(i>r||j<l)return -1;
        if (l >= i && r <= j) return ret[pi];
        else {
            int pp=rMin(i,j,left(pi),l,(r+l)/2,arr,ret);
            int ppp=rMin(i,j,right(pi),(r+l)/2+1,r,arr,ret);
            if(pp==-1)return ppp;
            if(ppp==-1) return pp;
            return (arr[pp] <= arr[ppp]) ? pp : ppp;//returns prevoius element in case of same elements
        }
    }
    static int rMin(int i,int j,int arr[],int ret[]){
        return rMin(i,j,0,0,arr.length-1,arr,ret);
    }






}
