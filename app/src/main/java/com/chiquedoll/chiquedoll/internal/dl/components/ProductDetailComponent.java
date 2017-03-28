package com.chiquedoll.chiquedoll.internal.dl.components;

import com.chiquedoll.chiquedoll.internal.dl.PerActivity;
import com.chiquedoll.chiquedoll.internal.dl.modules.ActivityModule;
import com.chiquedoll.chiquedoll.internal.dl.modules.ProductDetailActivityModule;
import com.chiquedoll.chiquedoll.view.fragment.ProductDetailFragment;

import dagger.Component;

/**
 * Created by super-zuo on 17-3-20.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = {ProductDetailActivityModule.class,ActivityModule.class})
public interface ProductDetailComponent {

    void inject(ProductDetailFragment productDetailFragment);

}
