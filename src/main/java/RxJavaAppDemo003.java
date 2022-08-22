import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.Action;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RxJavaAppDemo003 {

    public static void main(String[] args) {

        Observable<Integer> observable = Observable.range(2, 5);

        observable.subscribe(item -> {
            System.out.println(item);
        });

        Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);

        intervalObservable.subscribe(item -> {
            System.out.println(item);
        });

        Observable<Long> timeObservable = Observable.timer(5, TimeUnit.SECONDS);

        timeObservable.subscribe(item -> {
            System.out.println("5 seconds passed");
        });


        Action action = () -> System.out.println("Hello everybodies");
        Completable completable = Completable.fromAction(action);

        completable.subscribe(() -> {
            System.out.println("Action ends");
        });

        new Scanner(System.in).nextLine();



    }

}
