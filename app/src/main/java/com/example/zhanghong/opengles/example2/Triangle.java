package com.example.zhanghong.opengles.example2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Triangle {

    private FloatBuffer vertexBuffer;// Buffer for vertex-array
    private ByteBuffer indexBuffer;// Buffer for vertex-array

    private float[] vertexs = {
            0.0f, 1.0f, 0.0f,
            -1.0f, -1.0f, 0.0f,
            1.0f, -1.0f, 0.0f
    };

    private byte[] indexs = {0, 1, 2};

    public Triangle() {
        indexBuffer = ByteBuffer.allocateDirect(indexs.length);
        indexBuffer.order(ByteOrder.nativeOrder());
        indexBuffer.put(indexs);
        indexBuffer.position(0);

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertexs.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertexs);
        vertexBuffer.position(0);

    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, indexs.length, GL10.GL_UNSIGNED_BYTE, indexBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
