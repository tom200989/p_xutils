package com.pxutils.pxutils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.tcl.token.ndk.ServerEncrypt;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.request.UriRequest;
import org.xutils.x;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = findViewById(R.id.iv);
        x.image().bind(iv, "drawable://" + R.drawable.head_circle_test);
    }

    public void clickx(View view) {
        RequestParams entity = getNormalRequestParams();
        x.http().post(entity, new Callback.CommonCallback<String>() {

            @Override
            public void responseBody(UriRequest body) {

                // 打印请求连接
                String requestUri = body.getRequestUri();
                Log.v("mt30", "requestUri: " + requestUri);

                // 打印请求参数
                RequestParams params = body.getParams();
                int connectTimeout = params.getConnectTimeout();
                Log.v("mt30", "timeout: " + connectTimeout);

                try {
                    // 打印响应码
                    int responseCode = body.getResponseCode();
                    Log.v("mt30", "responseCode: " + responseCode);

                    // 打印响应头信息
                    Map<String, List<String>> responseHeaders = body.getResponseHeaders();
                    for (String key : responseHeaders.keySet()) {
                        List<String> values = responseHeaders.get(key);
                        if (values != null) {
                            for (String value : values) {
                                Log.v("mt30", "key == " + key + ";\tvalue == " + value);
                            }
                        }
                    }

                    // 打印响应Message
                    String responseMessage = body.getResponseMessage();
                    Log.v("mt30", "responseMessage: " + responseMessage);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onSuccess(String result) {
                Log.v("mt30", result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("mt30", ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private RequestParams getNormalRequestParams() {
        RequestParams requestParams = new RequestParams("https://www.alcatel-move.com/v1.0/account/login");
        // 基本信息
        requestParams.setConnectTimeout(30000);
        // 头部信息
        requestParams.addHeader("Authorization", getAuthorization());
        requestParams.addHeader("Content-Type", "application/json");
        requestParams.addHeader("Accept-Language", "en");
        requestParams.addHeader("User-Agent", android.os.Build.MANUFACTURER + "-" + android.os.Build.MODEL);
        // 参数
        requestParams.setAsJsonContent(true);
        String contentJson = JSON.toJSONString(new LoginParam("161058323@qq.com", "acz9bdw5"));
        requestParams.setBodyContent(contentJson);
        return requestParams;
    }

    private String getAuthorization() {
        ServerEncrypt encrypt = new ServerEncrypt("");
        String key = "key=" + "vEWZapEpW5OezzEs5Su44xAbCiy9-arCJz7eoLJfjac2h1r4VF0" + ";";
        String token = "token=" + "" + ";";
        String sign = "sign=" + encrypt.getSign() + ";";
        String timeStamp = "timestamp=" + encrypt.getTimestamp() + ";";
        String newToken = "newtoken=" + encrypt.getNewtoken() + ";";
        return key + token + sign + timeStamp + newToken;
    }
}
