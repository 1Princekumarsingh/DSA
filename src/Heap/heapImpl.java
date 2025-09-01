package Heap;

public class heapImpl {
    int heapSize;
    int heap[];
    int capacity;
    heapImpl(int[] arr){
        heap = arr;
        heapSize = arr.length;
        capacity = arr.length;
    }
    public void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[i] = temp;
    }
    public  void heapify(int i){
        int largest = i;
        int leftChildIdx = i*2+1;
        int rightChildIdx = i*2+2;

        if(leftChildIdx<heapSize && heap[leftChildIdx]>heap[largest]) largest = leftChildIdx;
        if(rightChildIdx<heapSize && heap[rightChildIdx]>heap[largest]) largest = rightChildIdx;

        if(largest!=i){//check if parent changed, if yes then swap
            swap(i, largest);
//            heapify(largest);
        }
    }
    public void buildTree(){
        //leaf ->n/2 to n-1
        //root -> 0 to n/2 -1
        for(int i=heapSize/2-1; i>=0; i--){
            heapify(i);
        }
    }
    public int extractMax(){
        if(heapSize== 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        int max = heap[0];
        heap[0] = heap[heapSize-1];
        heapSize--;
        heapify(0);
        return max;
    }
    public void increaseKey(int idx, int val){
        if(idx<0 || idx>=heapSize || val<heap[idx]){
            System.out.println("Wrong Operarion!");
            return;
        }
        heap[idx] = val;
        heapify(idx);
    }
    public void decreaseKey(int idx, int val){
        if(idx<0 || idx>=heapSize || val>heap[idx]){
            System.out.println("Wrong Operarion!");
            return;
        }
        heap[idx] = val;
        heapify(idx);
    }
    public  void insert(int val){
        if(heapSize==capacity){
            System.out.println("Wrong Operation!");
            return;
        }
        heap[heapSize] = val;
        heapify(heapSize);
        heapSize++;
    }
    public void display(){
        for(int i=0; i<heapSize; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {10,5,20,6,11};
        heapImpl heap=new heapImpl(arr);
        heap.buildTree();
        heap.display();
        int removedMax = heap.extractMax();

    }
}
