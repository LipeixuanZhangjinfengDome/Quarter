package com.example.administrator.quarter.ui.make;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.quarter.MainActivity;
import com.example.administrator.quarter.R;
import com.example.administrator.quarter.utils.ImageTool;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MakeDuanZiActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int IMG_COUNT = 8;
    private static final String IMG_ADD_TAG = "a";
    private GridView gridView;
    private GVAdapter adapter;
    private TextView textView;
    private ImageView img;
    private List<String> list;
    private TextView btn;
    private PopupWindow popupWindow;
    private LinearLayout ll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_duan_zi);
        gridView = (GridView) findViewById(R.id.gridview);
        textView = (TextView) findViewById(R.id.send);
        ll = (LinearLayout)findViewById(R.id.ll);
        btn = (TextView)findViewById(R.id.btn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakeDuanZiActivity.this, SuccessActivity.class);
                startActivity(intent);
                upLoad();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopupWindow();
                popupWindow.showAtLocation(ll, Gravity.BOTTOM, 0, 0);
            }
        });
        initData();
    }

    private void upLoad() {
        Bitmap bitmap;
        Bitmap bmpCompressed;
        for (int i = 0; i < list.size() - 1; i++) {
            bitmap = BitmapFactory.decodeFile(list.get(i));
            bmpCompressed = Bitmap.createScaledBitmap(bitmap, 640, 480, true);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bmpCompressed.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            byte[] data = bos.toByteArray();
            System.out.println(data);
        }

    }

    private void initData() {
        if (list == null) {
            list = new ArrayList<>();
            list.add(IMG_ADD_TAG);
        }
        adapter = new GVAdapter();
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list.get(position).equals(IMG_ADD_TAG)) {
                    if (list.size() < IMG_COUNT) {
                        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(i, 0);
                    } else
                        Toast.makeText(MakeDuanZiActivity.this, "最多只能选择7张照片！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        refreshAdapter();
    }

    private void refreshAdapter() {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (adapter == null) {
            adapter = new GVAdapter();
        }
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_take_photo:
                Intent intent = new Intent(MakeDuanZiActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_pick_photo:
                Intent intent1 = new Intent(MakeDuanZiActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_cancel:
                Intent intent2 = new Intent(MakeDuanZiActivity.this, MainActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }


    private class GVAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplication()).inflate(R.layout.layout_popwindow, parent, false);
                holder = new ViewHolder();
                holder.imageView = (ImageView) convertView.findViewById(R.id.main_gridView_item_photo);
                holder.checkBox = (CheckBox) convertView.findViewById(R.id.main_gridView_item_cb);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            String s = list.get(position);
            if (!s.equals(IMG_ADD_TAG)) {
                holder.checkBox.setVisibility(View.VISIBLE);
                holder.imageView.setImageBitmap(ImageTool.createImageThumbnail(s));
            } else {
                holder.checkBox.setVisibility(View.GONE);
                holder.imageView.setImageResource(R.drawable.tianjia);
            }
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    refreshAdapter();
                }
            });
            return convertView;
        }

        private class ViewHolder {
            ImageView imageView;
            CheckBox checkBox;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            System.out.println("data null");
            return;
        }
        if (requestCode == 0) {
            final Uri uri = data.getData();
            String path = ImageTool.getImageAbsolutePath(this, uri);
            System.out.println(path);
            if (list.size() == IMG_COUNT) {
                removeItem();
                refreshAdapter();
                return;
            }
            removeItem();
            list.add(path);
            list.add(IMG_ADD_TAG);
            refreshAdapter();
        }
    }

    private void removeItem() {
        if (list.size() != IMG_COUNT) {
            if (list.size() != 0) {
                list.remove(list.size() - 1);
            }
        }
    }

    private void initPopupWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_item, null);
        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout
                .LayoutParams.WRAP_CONTENT);
        //点击PopupWindow外部可以取消
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        Button btn_take_photo = view.findViewById(R.id.btn_take_photo);
        Button btn_pick_photo = view.findViewById(R.id.btn_pick_photo);
        Button btn_cancel = view.findViewById(R.id.btn_cancel);
        btn_take_photo.setOnClickListener(this);
        btn_pick_photo.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

    }

}
