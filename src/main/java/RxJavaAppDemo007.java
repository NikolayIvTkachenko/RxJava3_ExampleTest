import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class RxJavaAppDemo007 {

    public static void main(String[] args) {

        //disposableExample1();
        //disposableExample2();
        //disposableExample3();

    }

    public static void disposableExample1() {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = seconds.subscribe(item -> System.out.println("Item: " + item));

        if(disposable.isDisposed()){
            disposable.dispose();
        }
    }


    public static void disposableExample2() {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        seconds.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(@NonNull Long aLong) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        compositeDisposable.dispose();

    }


    public static void disposableExample3() {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        
    }

}
