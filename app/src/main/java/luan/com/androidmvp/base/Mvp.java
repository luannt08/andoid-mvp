package luan.com.androidmvp.base;

/*
* This is MVP-base class used for all module, all common functions are declared here
*/

public interface Mvp {

    /*
    * base Model layer
    */
    interface Model <P>{
        /*
        * Pass the instance of Presenter in to Model
        *
        * @param presenter the instance of Presenter corresponding with Model
        */
        void takePresenter(P presenter);
    }

    interface View {
        /*
        * Show loading in View
        * @param isShow boolean
        * */
        void showLoading(boolean isShow);

        void showError();
    }

    interface Presenter<V, M> {
        void takeView(V view);

        void error();
    }
}
