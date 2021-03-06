/*
 * Copyright (c) 2019  STMicroelectronics – All rights reserved
 * The STMicroelectronics corporate logo is a trademark of STMicroelectronics
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this list of conditions
 *   and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above copyright notice, this list of
 *   conditions and the following disclaimer in the documentation and/or other materials provided
 *   with the distribution.
 *
 * - Neither the name nor trademarks of STMicroelectronics International N.V. nor any other
 *   STMicroelectronics company nor the names of its contributors may be used to endorse or
 *   promote products derived from this software without specific prior written permission.
 *
 * - All of the icons, pictures, logos and other images that are provided with the source code
 *   in a directory whose title begins with st_images may only be used for internal purposes and
 *   shall not be redistributed to any third party or modified in any way.
 *
 * - Any redistributions in binary form shall not include the capability to display any of the
 *   icons, pictures, logos and other images that are provided with the source code in a directory
 *   whose title begins with st_images.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
 * AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 */
package com.st.BlueMS.demos.ActivityRecognition;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.st.BlueMS.R;
import com.st.BlueSTSDK.Features.FeatureActivity;

/**
 * View to display the output of the MLC activity recognition algorithm
 */
public class HumanActivityRecognitionMLCView extends ActivityView {

    public HumanActivityRecognitionMLCView(Context context) {
        super(context);
        init(context);
    }

    public HumanActivityRecognitionMLCView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HumanActivityRecognitionMLCView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * image to select for the stationary activity
     */
    private ImageView mStationaryImage;

    /**
     * image to select for the walking activity
     */
    private ImageView mWalkingImage;

    /**
     * image to select for the jogging activity
     */
    private ImageView mJoggingImage;

    /**
     * image to select for the biking activity
     */
    private ImageView mBikingImage;

    /**
     * image to select for the driving activity
     */
    private ImageView mDrivingImage;

    @Nullable
    ImageView getSelectedImage(@NonNull FeatureActivity.ActivityType status){
        switch(status){
            case STATIONARY:
                return mStationaryImage;
            case WALKING:
                return mWalkingImage;
            case JOGGING:
                return mJoggingImage;
            case BIKING:
                return mBikingImage;
            case DRIVING:
                return mDrivingImage;
            default:
                return null;
        }//switch
    }//getSelectedImage

    private void init(Context context){
        inflate(context, R.layout.view_activity_mlc,this);

        //extract all the image and set the alpha
        mStationaryImage = findViewById(R.id.activity_mlc_stationaryImage);
        mWalkingImage =  findViewById(R.id.activity_mlc_walkingImage);
        mJoggingImage =  findViewById(R.id.activity_mlc_joggingImage);
        mBikingImage =  findViewById(R.id.activity_mlc_bikingImage);
        mDrivingImage =  findViewById(R.id.activity_mlc_drivingImage);

        deselectAllImages();
    }

}
