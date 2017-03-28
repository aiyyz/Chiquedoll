package com.chiquedoll.chiquedoll.view.activity;

import android.os.Bundle;

import com.chiquedoll.chiquedoll.R;
import com.chiquedoll.chiquedoll.internal.dl.HasComponent;
import com.chiquedoll.chiquedoll.internal.dl.components.DaggerProductDetailComponent;
import com.chiquedoll.chiquedoll.internal.dl.components.ProductDetailComponent;
import com.chiquedoll.chiquedoll.internal.dl.modules.ProductDetailActivityModule;
import com.chiquedoll.chiquedoll.view.fragment.ProductDetailFragment;

/**
 * Created by super-zuo on 17-3-20.
 */

public class ProductDetailActivity extends BaseActivity implements HasComponent<ProductDetailComponent> {

    private ProductDetailComponent productDetailComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        initializeActivity();
        initializeInjector();
    }

    private void initializeActivity() {
        addFragment(R.id.fragmentContainer,new ProductDetailFragment());
    }

    private void initializeInjector() {
        productDetailComponent = DaggerProductDetailComponent.builder()
                .applicationComponent(getApplicationComponent())
                .productDetailActivityModule(new ProductDetailActivityModule(this))
                .activityModule(getActivityModule())
                .build();
    }


    @Override
    public ProductDetailComponent getComponent() {
        return productDetailComponent;
    }
}
