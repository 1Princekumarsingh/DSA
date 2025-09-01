package Heap;

class heapImpl {//max heap
        private int[] heap;
        private int size;
        private int capacity;

        public heapImpl(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            heap = new int[capacity];
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        private void heapifyUp(int i) {//bubble up
            int parent = (i - 1) / 2;
            if(i > 0 && heap[i] > heap[parent]) {
                swap(i, parent);
                heapifyUp(parent);
            }
        }

        private void heapifyDown(int i) {//bubble down
            int largest = i;
            int left = 2*i + 1, right = 2*i + 2;

            if(left < size && heap[left] > heap[largest]) largest = left;
            if(right < size && heap[right] > heap[largest]) largest = right;

            if(largest != i) {
                swap(i, largest);
                heapifyDown(largest);
            }
        }

        public void insert(int val) {
            if(size == capacity) {
                System.out.println("Heap is full!");
                return;
            }
            heap[size] = val;
            size++;
            heapifyUp(size - 1);
        }

        public int extractMax() {
            if(size == 0) {
                System.out.println("Heap is empty!");
                return -1;
            }
            int max = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            return max;
        }

        public void display() {
            for(int i = 0; i < size; i++) System.out.print(heap[i] + " ");
            System.out.println();
        }

        public static void main(String[] args) {
            heapImpl maxHeap = new heapImpl(10);
            maxHeap.insert(10);
            maxHeap.insert(5);
            maxHeap.insert(20);
            maxHeap.insert(6);
            maxHeap.insert(11);

            System.out.print("Max-Heap: ");
            maxHeap.display();

            System.out.println("Extract Max: " + maxHeap.extractMax());
            maxHeap.display();
        }
    }
