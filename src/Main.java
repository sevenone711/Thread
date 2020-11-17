import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        lowThread(arr);
        fastThread(arr, HALF);
    }

      static void lowThread(float arr[]){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        System.out.println("Strar Low Thread");
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
        System.out.print("Stop low Thread: ");
        System.out.println(System.currentTimeMillis() - a);
    }
    public static void fastThread(float[] arr, int h){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println("Strar Fast Thread");
        float a1[] = new float[h];
        float a2[] = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr,h , a2, 0, h);
//        new Thread(new Runnable() {
//            @Override
//            public void run () {
//                for (int i = 0; i < a1.length; i++) {
//                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run () {
//                for (int i = 0; i < a2.length; i++) {
//                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                }
//            }
//        }).start();
        var t1 = new Thread(new Runnable() {
            @Override
            public void run () {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        var t2 = new Thread(new Runnable() {
            @Override
            public void run () {
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.print("Stop fast Thread: ");
        System.out.println(System.currentTimeMillis() - a);

    }
}
