import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxJavaAppDemo014_Threads {

    public static void main(String[] args) {

//        System.out.println("=== Test 01 ===");
//        Observable.just(1, 2, 3, 4, 5)
//                .doOnNext(item -> System.out.println("Pushing item " + item + " on " + Thread.currentThread().getName() + " thread"))
//                .subscribe(item -> {
//                    System.out.println("Received item " + item + " on " + Thread.currentThread().getName() + " thread \n");
//                });
//
//        System.out.println("=== Test 02 ===");
//        Observable.just("Hello world")
//                .subscribeOn(Schedulers.io())
//                .doOnNext(item -> System.out.println("Emitting item: " + Thread.currentThread().getName()))
//                .subscribe(item -> System.out.println("Observing item: " + Thread.currentThread().getName()));


        System.out.println("=== Test 03 ===");
        Observable.just("Hello world Test 02")
                //.subscribeOn(Schedulers.io())
                .doOnNext(item -> System.out.println("Emitting item: " + Thread.currentThread().getName()))
                //.subscribeOn(Schedulers.computation())
                .doOnNext(item -> System.out.println("Emitting item: " + Thread.currentThread().getName()))
                .subscribeOn(Schedulers.newThread())
                .doOnNext(item -> System.out.println("Emitting item: " + Thread.currentThread().getName()))
                .observeOn(Schedulers.single())
                .subscribe(item -> System.out.println("Observing item: " + Thread.currentThread().getName()));



        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
