package com.chiquedoll.chiquedoll.internal.dl.modules;

import android.content.Context;

import com.chiquedoll.data.repository.ProductDataRepository;
import com.chquedoll.domain.repository.ProductRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by super-zuo on 17-3-24.
 */

@Module
public class ProductDetailActivityModule {


    private final Context context;

    public ProductDetailActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    ProductRepository provideProductRepository(ProductDataRepository productDataRepository){
        return productDataRepository;

    }
}
