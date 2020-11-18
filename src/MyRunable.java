public class MyRunable implements Runnable {
    private float[] arr;
    MyRunable(float[] ar){
        this.arr = ar;
    }
    @Override
    public void run () {
        for (int i = 0; i < arr.length; i++) {
                    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
    }

