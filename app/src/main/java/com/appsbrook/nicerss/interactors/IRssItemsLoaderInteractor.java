package com.appsbrook.nicerss.interactors;

import com.appsbrook.nicerss.data.RssItem;

import java.util.List;

public interface IRssItemsLoaderInteractor {

    void onLoadSuccess(List<RssItem> items);

    void onLoadFail();
}
