package com.swc.onestop.Activities.Freshers.inner;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.swc.onestop.Activities.Freshers.utils.GlideApp;
import com.swc.onestop.R;


import org.greenrobot.eventbus.EventBus;

public class InnerItem  extends com.ramotion.garlandview.inner.InnerItem {

    private final View mInnerLayout;

    public final TextView mHeader;
    public final TextView mName;
    public final TextView mAddress;
    public final ImageView mAvatar;
    public final View mAvatarBorder;
    public final View mLine;

    private InnerData mInnerData;
    private String innerDocumentID;
    private String outerDocumentID;

    public InnerItem(View itemView) {
        super(itemView);
        mInnerLayout = ((ViewGroup)itemView).getChildAt(0);

        mHeader = (TextView) itemView.findViewById(R.id.tv_header);
        mName = (TextView) itemView.findViewById(R.id.tv_name);
        mAddress = (TextView) itemView.findViewById(R.id.tv_address);
        mAvatar = (ImageView) itemView.findViewById(R.id.avatar);
        mAvatarBorder = itemView.findViewById(R.id.avatar_border);
        mLine = itemView.findViewById(R.id.line);

        mInnerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(InnerItem.this);
            }
        });
    }

    @Override
    protected View getInnerLayout() {
        return mInnerLayout;
    }

    public InnerData getItemData() {
        return mInnerData;
    }

    public void clearContent() {
        GlideApp.with(mAvatar.getContext()).clear(mAvatar);
        mInnerData = null;
    }

    void setContent(InnerData data) {
        mInnerData = data;
        innerDocumentID=data.innerID;
        outerDocumentID=data.outerID;

        mHeader.setText(data.title);
        mName.setText(String.format("%s ",data.name));
        mAddress.setText(String.format("%s · %s",
                mAddress.getContext().getString(R.string.Years), data.address));

        GlideApp.with(itemView.getContext())
                .load(data.avatarUrl)
                .placeholder(R.drawable.avatar_placeholder)
                .transform(new CircleCrop())
                .into(mAvatar);
    }

}