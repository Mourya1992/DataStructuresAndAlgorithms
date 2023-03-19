package org.example.Sorting;


public class SortingAlgorithms {

    public void swapLogic(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public int partition(int[] arr,int low,int high){
        int pvt=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pvt){
                i++;
                swapLogic(arr,i,j);
            }


        }
        swapLogic(arr,i+1,high);
        return i+1;
    }

    public void quickSort(int[] arr,int low ,int high){
        if(low<high) {
            int index = partition(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }

    }

    public void divide(int[] arr, int si,int ei){
        int mid = si+(ei-si)/2;
        if(si<ei){
            divide(arr,si,mid);
            divide(arr,mid+1,ei);
            conqure(arr,si,ei,mid);
        }

    }

    public void conqure(int[] arr,int si,int ei,int mid){
        int[] ltArr = new int[mid-si+1];
        int[] rtArr = new int[ei-mid];
        int index1=0;
        int index2 =0;
        int x=si;
        for(int i=0;i<ltArr.length;i++){
            ltArr[i]=arr[si+i];
        }
        for(int j=0;j<rtArr.length;j++)
        {
            rtArr[j]=arr[mid+1+j];
        }
        while(index1<ltArr.length && index2<rtArr.length){
            if(ltArr[index1]>rtArr[index2]){
                arr[x]=ltArr[index1];
                index1++;
                x++;
            }else {
                arr[x]=rtArr[index2];
                index2++;
                x++;
            }
        }
        while (index1< ltArr.length){
            arr[x]=ltArr[index1];
            x++;
            index1++;
        }
        while (index2< rtArr.length){
            arr[x]=rtArr[index2];
            x++;
            index2++;
        }
    }
    public static void main(String[] args) {
        System.out.println("say hi");
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        int[] arrayinput = {7,3,16,9,12,1,33,10,88,123,56};
       // sortingAlgorithms.quickSort(arrayinput,0,arrayinput.length-1);
        sortingAlgorithms.divide(arrayinput,0,arrayinput.length-1);
        sortingAlgorithms.printArray(arrayinput);
    }
}
