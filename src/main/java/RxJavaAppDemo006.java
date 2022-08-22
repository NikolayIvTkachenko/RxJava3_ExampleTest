import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class RxJavaAppDemo006 {

    public static void main(String[] args) throws InterruptedException {

        //synchronousObservableExample();
        //asyncObserverableExample();
        //asyncFlowableExample();


        //coldObservableExample();
        hotObservableExample();



    }

    private static void coldObservableExample() {
        Observable observable = Observable.just("a", "b", "c", "d", "e");

        observable.subscribe((item) -> System.out.println("Observer 1 - " + item));
        observable.subscribe((item) -> System.out.println("Observer 2 - " + item));
        observable.subscribe((item) -> System.out.println("Observer 3 - " + item));

    }

    private static void hotObservableExample() throws InterruptedException {
        ConnectableObservable observable = Observable.interval(1, TimeUnit.SECONDS).publish();

        observable.connect();

        observable.subscribe((item) -> {
            System.out.println("Observer 1, sec: " + item);
        });

        Thread.sleep(5000);

        observable.subscribe((item) -> {
            System.out.println("Observer 2, sec: " + item);
        });

        Thread.sleep(100000);

    }


    private static void synchronousObservableExample(){
        Observable.range(1, 10000000)
                .map(id -> new Item(id))
                .subscribe( item -> {
                    Thread.sleep(1000);
                    System.out.println("Received MyItem " + item.getValue() + "\n");
                });
    }

    private static void asyncObserverableExample(){
        Observable.range(1, 10000000)
                .map(id -> new Item(id))
                .observeOn(Schedulers.io())
                .subscribe( item -> {
                    Thread.sleep(1000);
                    System.out.println("Received MyItem " + item.getValue() + "\n");
                });
        try{
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void asyncFlowableExample(){
        Flowable.range(1, 1000000)
                .map(Item::new)
                .observeOn(Schedulers.io())
                .subscribe(item ->{
                    Thread.sleep(20);
                    System.out.println("Received MyItem " + item.getValue() +"\n");
                });
        try{
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


class Item{

    private Integer value;

    public Item(Integer item) {
        this.value = item;
    }

    public Integer getValue() {
        return value;
    }
}