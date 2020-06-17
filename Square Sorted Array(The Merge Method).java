class Solution {
   public int[] sortedSquares(int[] A) {
        int div = 0;
        int length = A.length;
        for(int i =0; i<length;i++){
            if(A[i]>=0){
                div = i;
                break;
            }
        }

        int[] aux = new int[length];
        for(int i = 0;i<length;i++){
            aux[i] = A[i]*A[i];
        }


        //reverse the before div items
        int m = 0;
        int n = div-1;
        while(m<n){
            int temp =0;
            temp = aux[m];
            aux[m] = aux[n];
            aux[n] = temp;
            m = m+1;
            n = n-1;
        }

        //merge
        int i = 0;
        int j = div;
        for(int k = 0;k<length;k++){
            if(i>=div){
                A[k] = aux[j]; j++;
            }else if(j>=length){
                A[k] = aux[i];i++;
            }else if(aux[i]<aux[j]){
                A[k] = aux[i]; i++;
            }else{
                A[k] = aux[j]; j++;
            }
        }

        return A;

    }
    
}