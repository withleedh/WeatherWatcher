package com.ge.appl.weatherwatcher;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private class ViewHolder{
       public ImageView mWeatherImage;
       public TextView mDayOfWeek;
        public TextView mMonthDay;
        public TextView mWeather;
        public TextView mTemperature;

    }

    public class ListViewAdapter extends BaseAdapter{

        private Context mContext = null;
        private ArrayList<WeatherData> mWeatherDataList = new ArrayList<WeatherData>();

        public ListViewAdapter(Context mContext){
            super();
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mWeatherDataList.size();
        }

        @Override
        public Object getItem(int position) {
            return mWeatherDataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if (view == null){
                holder = new ViewHolder();

                LayoutInflater inflater = LayoutInflater.from(mContext);
                view = inflater.inflate(R.layout.weather_listview_item,null);

                holder.mWeatherImage = (ImageView) view.findViewById(R.id.mWeatherImage);
                holder.mDayOfWeek = (TextView) view.findViewById(R.id.mDayOfWeek);
                holder.mMonthDay = (TextView) view.findViewById(R.id.mMonthDay);
                holder.mWeather = (TextView) view.findViewById(R.id.mWeather);
                holder.mTemperature = (TextView) view.findViewById(R.id.mTemperature);

                view.setTag(holder);
            }else{
                holder = (ViewHolder)view.getTag();
            }

            WeatherData weatherData = mWeatherDataList.get(position);

            holder.mWeatherImage.setImageDrawable(weatherData.getWeatherImage());

            return view;
        }
    }
}

