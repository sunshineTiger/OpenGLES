package com.example.zhanghong.opengles;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyGLRenderer2 implements GLSurfaceView.Renderer{
    private Triangle mTriangle;

    //当Surface创建或者被创建时调用
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        mTriangle = new Triangle();
    }

    //当Surface窗口改变时调用
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    //加载Shader
    public static int loadShader(int type, String shaderCode){
        int shader = GLES20.glCreateShader(type);
        //加载shader代码 glShaderSource 和 glCompileShader
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }

    //调用来绘制当前帧。
    @Override
    public void onDrawFrame(GL10 gl) {
        mTriangle.draw();
    }
}
