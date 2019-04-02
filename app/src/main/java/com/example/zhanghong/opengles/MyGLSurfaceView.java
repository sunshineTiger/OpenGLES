package com.example.zhanghong.opengles;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSurfaceView extends GLSurfaceView {

    private MyGLRenderer2 mRenderer;

    public MyGLSurfaceView(Context context) {
        super(context);
        //Create an OpenGL ES 2.0 context创建客户端版本
        setEGLContextClientVersion(2);
        //实例化MyGLRenderer2对象
        if (null == mRenderer)
            mRenderer = new MyGLRenderer2();
        //Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
        //Set the RenderMode
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }

}
