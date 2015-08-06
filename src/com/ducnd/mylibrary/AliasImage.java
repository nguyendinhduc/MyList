package com.ducnd.mylibrary;

import android.graphics.Bitmap;

public class AliasImage {
	public static Bitmap applySmoothEffect(Bitmap src, double value) {
		  //create convolution matrix instance
		  ConvolutionMatrix convMatrix = new ConvolutionMatrix(3);
		  convMatrix.setAll(1);
		  convMatrix.Matrix[1][1] = value;
		  // set weight of factor and offset
		  convMatrix.Factor = value + 8;
		  convMatrix.Offset = 1;
		  return ConvolutionMatrix.computeConvolution3x3(src, convMatrix);
	}
}
