public class Main {

    public static void main(String[] args) {
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        lowThread(arr);
    }






    static void lowThread(float arr[]){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

    }
    public void fastThread(float[] arr){

    }
}
