package com.example.shundai.allactivitydialog;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity  {

    private static final String TAG = "MainActivityyy";
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    Gson gson=new Gson();
    public static final String json="{\"alipay_trade_app_pay_response\":{\"code\":\"10000\",\"msg\":\"Success\",\"app_id\":\"2016111602877934\",\"auth_app_id\":\"2016111602877934\",\"charset\":\"utf-8\",\"timestamp\":\"2017-08-29 11:54:04\",\"total_amount\":\"0.01\",\"trade_no\":\"2017082921001004390290359401\",\"seller_id\":\"2088521151595329\",\"out_trade_no\":\"5837230981e548d49fca0cfe9cfa5271\"},\"sign\":\"fppYgjrYGkQNlcb50RXDtXlONM8KGoKb9OtAQMGUKdXQRVqFIJuqlW3twoQUdPNWBPargZwJdAxbOdKgAqk6p/8zjDyVbQ3WLDSLUZ5bKCCQRnd8VCxtKZdUz0YYb3aYnnVErpPBWqsECS/2AA/Nf0Pu+c4gBzQWhPTTszPaFcIn+joBihs4d66SuhyDvRVlR0gUBLXDAFaxkHyBXMmWmD3MGtPpr4HYFICHgafCgo0iEGSos3ktVFvNECG6U+3hkJ6GAVaMYEBclN6A6yA1zSQ2+4qQOT6RRyf865hi98ahVe1KCigfptDM9qFOFWsRZfeLv2dGUlPhB8D4XhyH7A==\",\"sign_type\":\"RSA2\"}";
    public static final String json1="\"{\\\"alipay_trade_app_pay_response\\\":{\\\"code\\\":\\\"10000\\\",\\\"msg\\\":\\\"Success\\\",\\\"app_id\\\":\\\"2016111602877934\\\",\\\"auth_app_id\\\":\\\"2016111602877934\\\",\\\"charset\\\":\\\"utf-8\\\",\\\"timestamp\\\":\\\"2017-08-29 10:24:41\\\",\\\"total_amount\\\":\\\"0.01\\\",\\\"trade_no\\\":\\\"2017082921001004750258007541\\\",\\\"seller_id\\\":\\\"2088521151595329\\\",\\\"out_trade_no\\\":\\\"c300fe463cdd43c38287f70bcf00e471\\\"},\\\"sign\\\":\\\"dFwHOcZgVkGfFYxUlLw0K5Q6i3lffk2V+1vUEpaotiFPlYxWLpV1Jn8Du+gpTcb/AF35Q8lbaqNGP59EFBu+u9OZeTZNemGJXUxjeVs78/HYxQTFppsYEY6MWAvbWpAlAe+VDS6YoZTnnmpCpowoHI2ix9mb1rN2sTsZeuimHvahYXErAMJF0uq2dO69pIeCARQI/bi66i+8kZF1OHJn+lqu78hnnl1rGd8Zs0rrpzaE6V6bHqVMGg35EW/NcuGn3XuhYGEXdSzrv2M5oRUrH6jJSZ7aIN8UFI6yPSGq1CA1OVoZzzNw6H0gX2Ymkpkd1Ey8pdNDYe/6QP8QJwCozQ==\\\",\\\"sign_type\\\":\\\"RSA2\\\"}\";";
    public static final String json2="{\"body\":{\"onstatus\":1,\"pk_eid\":1591237111804073192},\"tag\":\"Esc\",\"opttime\":1504079693555,\"action\":\"Esc_Onoff\",\"key\":\"Esc_1591237111804073192\"}";
    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        PayResultBean payResultBean = gson.fromJson(json, PayResultBean.class);
        String payBean = gson.toJson(payResultBean);
        Log.d(TAG, "initData: >>>>>>>>>>>>>>>>>"+payBean);

        if (BuildConfig.DEBUG){
            Toast.makeText(this, "BuildConfig", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void initView() {

    }
    @OnClick({R.id.btn1, R.id.btn2,R.id.btn3,R.id.btn4,R.id.bt5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                CareTopDialog careTopDialog = new CareTopDialog(this);
                if (careTopDialog != null && !careTopDialog.isShowing()) {
                    careTopDialog.show();
                }

                break;
            case R.id.btn2:
                OrderTopDialog orderTopDialog = new OrderTopDialog(this);
                if (orderTopDialog != null && !orderTopDialog.isShowing()) {
                    orderTopDialog.show();
                }
                break;
            case R.id.btn3:
                startService(new Intent(this,SmartOrderService.class));

                break;
            case R.id.btn4:
                stopService(new Intent(this,SmartOrderService.class));

                break;
            case R.id.bt5:
                startActivity(new Intent(this,Main2Activity.class));
                break;
        }
    }
}
