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
    private String productId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        initializeActivity(savedInstanceState);
        initializeInjector();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (outState != null){
            outState.putString("productId",productId);
        }
    }

    private void initializeActivity(Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            productId = getIntent().getStringExtra("productId");
            addFragment(R.id.fragmentContainer, ProductDetailFragment.forProduct(this.productId));
        } else {
            productId = savedInstanceState.getString("productId");
        }
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
