import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;


public class RxJavaAppDemo005 {

    public static void main(String[] args) {

        Completable completable = createCompletable();

        completable.subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError");
                System.out.println("e = " + e.getMessage());
            }
        });




    }


    private static Completable createCompletable(){
        return Completable.fromAction(deleteFromDbAction());
    }

    private static Action deleteFromDbAction(){
        return new Action() {
            @Override
            public void run() throws Throwable {
                System.out.println("Deleting item from database");
            }
        };
    }

}
