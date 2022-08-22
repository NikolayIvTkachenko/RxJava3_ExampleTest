import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.ArrayList;
import java.util.List;

public class RxJavaAppDemo002 {

    public static void main(String[] args) {

        Observable<String> observable = Observable.just(
                "Message 001",
                "Message 002",
                "Message 003"
        );

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("onNext = " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        observable.subscribe(observer);



        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        Observable<Integer> observable2 = Observable.fromIterable(numbers);
        Observer<Integer> observer2 = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("onNext = " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        observable2.subscribe(observer2);

    }

}
