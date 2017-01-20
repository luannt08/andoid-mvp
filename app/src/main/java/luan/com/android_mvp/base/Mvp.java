package luan.com.android_mvp.base;


public interface Mvp {
    interface Model <P>{
        void takePresenter(P presenter);
    }

    interface View {
        void showLoading(boolean isShow);

        void showError();
    }

    interface Presenter<V, M> {
        void takeView(V view);

        void takeModel(M model);

        void error();
    }
}
