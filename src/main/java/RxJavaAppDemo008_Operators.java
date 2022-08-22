import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class RxJavaAppDemo008_Operators {

    public static void main(String[] args) {

        System.out.println("== filter(item -> item.length() != 2 =====");
        Observable.just("Hello", "My", "World")
                .filter(item -> item.length() != 2)
                .subscribe(item -> System.out.println(item));


        System.out.println("== take =====");
        Observable.just("Hello", "My", "World")
                .take(2)
                .subscribe(item -> System.out.println(item));


        System.out.println("== skip =====");
        Observable.just("Hello", "My", "World")
                .skip(2)
                .subscribe(item -> System.out.println(item));


        System.out.println("== distinct =====");
        Observable.just("Hello", "My", "World", "My", "My")
                .distinct()
                .subscribe(item -> System.out.println(item));

        System.out.println("== last =====");
        Observable.just(2, 3, 4, 5, 6)
                .last(-1)
                .subscribe(item -> System.out.println(item));


        System.out.println("== first =====");
        Observable.just(2, 3, 4, 5, 6)
                .first(-1)
                .subscribe(item -> System.out.println(item));

        System.out.println("== skipWhile =====");
        Observable.just(2, 3, 4, 5, 6)
                .skipWhile(item -> item < 4)
                .subscribe(item -> System.out.println(item));


        System.out.println("== takeWhile =====");
        Observable.just(2, 3, 4, 5, 6)
                .takeWhile(item -> item < 4)
                .subscribe(item -> System.out.println(item));


        System.out.println("== all =====");
        Observable.just("jack", "tuck", "luck")
                .all(item -> item.length() == 4)
                .subscribe(item -> System.out.println(item));


        System.out.println("== any =====");
        Observable.just("jack", "tuck", "luck")
                .any(item -> item.length() == 3)
                .subscribe(item -> System.out.println(item));


        System.out.println("== defaultIfEmpty =====");
        Observable.just("jack", "tuck", "luck")
                .filter(item -> item.length() == 3)
                .defaultIfEmpty("ABC")
                .subscribe(item -> System.out.println(item));

        System.out.println("== switchIfEmpty =====");
        Observable.just("jack", "tuck", "luck")
                .filter(item -> item.length() == 3)
                .switchIfEmpty(Observable.just("Hello", "World!"))
                .subscribe(item -> System.out.println(item));

        System.out.println("== map =====");
        Observable.just(2, 3, 4, 5, 6)
                .map(item -> String.valueOf(item + "D"))
                .subscribe(item -> System.out.println(item));


        System.out.println("== sorted =====");
        Observable.just(9, 3, 2, 5, 6)
                .sorted()
                .subscribe(item -> System.out.println(item));

        System.out.println("== scan=====");
        Observable.just(1, 2, 3, 4, 5)
                .scan((accumulator, item) -> accumulator + item)
                .subscribe(item -> System.out.println(item));


        System.out.println("== buffer =====");
        Observable.range(0, 10)
                .buffer(3)
                .subscribe(item -> System.out.println(item));

        System.out.println("== groupBy =====");
        Observable.just("a", "a", "bb", "bb", "ccc", "ccc", "ccc")
                .groupBy(item -> item.length())
                .flatMapSingle(group -> group.toList())
                .subscribe(item -> System.out.println(item));


        System.out.println("== flatMap =====");
        Observable.just(1, 2, 3)
                .flatMap(item -> Observable.just(item * 2))
                .subscribe(item -> System.out.println(item));

        System.out.println("== toList =====");
        Observable.just(1, 2, 3)
                .toList()
                .subscribe(item -> System.out.println(item));


        System.out.println("== mergeWith =====");
        Observable.just(1, 2, 3)
                .mergeWith(Observable.just(4, 5, 6))
                .subscribe(item -> System.out.println(item));

        System.out.println("== zipWith =====");
        var obj01 = Observable.just("A", "B");
        var obj02 = Observable.just("C", "D");

        obj01.zipWith(obj02, (item1, item2) -> {
            return String.format("%s%s", item1, item2);
        }).subscribe(finalResult -> System.out.println("Item: " + finalResult));


        System.out.println("== delay =====");
        Observable.just("Hello World!")
                .delay(2, TimeUnit.SECONDS)
                .subscribe(item -> System.out.println(item));

        System.out.println("== timeout =====");
        Observable.just("Hello World!!!!!")
                .timeout(10, TimeUnit.SECONDS)
                .subscribe(item -> System.out.println(item));

        System.out.println("== observeOn =====");
        System.out.println(Thread.currentThread().getName());
        Observable.just("World War III")
                .observeOn(Schedulers.newThread())
                .subscribe(item -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(item);
                });

        System.out.println("== subscribeOn =====");
        Observable.just("World War IV")
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(item -> {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println(item);
                    });


        System.out.println("== doOnNex =====");
        Observable.just(1, 2, 3)
                .doOnNext(item -> System.out.println("Log some info"))
                .filter(item -> item == 2)
                .subscribe(item -> {
                    System.out.println(item);
                });

        System.out.println("== doOnDispose =====");
        Disposable disposable = Observable.timer(1, TimeUnit.SECONDS)
                .doOnDispose(() -> System.out.println("Disposed called"))
                .subscribe(item -> {
                    System.out.println(item);
                });
        disposable.dispose();

        System.out.println("== retry =====");
        Observable.just(2, 1, 0)
                .map(item -> 2 / item)
                .retry(0)
                .subscribe(item -> {
                    System.out.println(item);
                }, throwable -> {
                    System.out.println(throwable.getMessage());
                });

        System.out.println("== onErrorReturnItem =====");
        Observable.just(2, 1, 0)
                .map(item -> 2 / item)
                .onErrorReturnItem(-1)
                .subscribe(item -> System.out.println(item));

        System.out.println("== onErrorResumeWith =====");
        Observable.just(2, 1, 0)
                .map(item -> 2 / item)
                .onErrorResumeWith(Observable.just(3, 4, 5))
                .subscribe(item -> System.out.println(item));






    }


}
