package com.chiquedoll.chiquedoll.view.fragment;

import android.support.v4.app.Fragment;

import com.chiquedoll.chiquedoll.internal.dl.HasComponent;
import com.chiquedoll.chiquedoll.view.LoadDataView;

/**
 * Created by super-zuo on 17-3-20.
 */

public class BaseFragment extends Fragment {

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
