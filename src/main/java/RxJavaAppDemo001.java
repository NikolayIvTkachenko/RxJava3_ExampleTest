import io.reactivex.rxjava3.core.Observable;

public class RxJavaAppDemo001 {

    public static void main(String[] args) {

        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("Message 01");
            emitter.onNext("Message 02");
            emitter.onNext("Message 03");
            //throw  new Exception("Something exception");
            emitter.onComplete();
        });


        observable.subscribe(obj -> {
            System.out.println(obj);
        }, throwable -> {
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("Completed");
        });

    }

}
