import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableOperator;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.observers.DisposableObserver;

public class RxJavaAppDemo013_CustomOperator {

    public static void main(String[] args) {

        Observable.just(1, 2, 3, 4)
                .filter(item -> item % 2 == 0)
                .subscribe(item -> System.out.println(item));


        Observable.just(1, 2, 3, 4)
                .lift(takeEven())
                .subscribe(item -> System.out.println(item));


    }

    private static ObservableOperator<Integer, Integer> takeEven() {
        return new ObservableOperator<Integer, Integer>() {

            @Override
            public @NonNull Observer<? super Integer> apply(@NonNull Observer<? super Integer> observer) throws Throwable {
                return new DisposableObserver<Integer>() {
                    @Override
                    public void onNext(@NonNull Integer item) {
                        if(item % 2 == 0){
                            observer.onNext(item);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                };
            }
        };
    }

}
