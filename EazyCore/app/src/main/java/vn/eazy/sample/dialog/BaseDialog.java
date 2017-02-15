package vn.eazy.sample.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import vn.eazy.sample.R;

/**
 * Created by Liam Vo on 2/14/17.
 */

public class BaseDialog extends Dialog {

    public BaseDialog(Context context) {
        super(context);
    }

    public BaseDialog(Context context, int theme) {
        super(context, theme);
    }

    /**
     * Helper class for creating custom Dialog
     *
     * @author Liam Vo
     */
    public static class Builder {
        private Context context;
        private int icon;
        private String title;
        private String message;
        private String positiveBtnText;
        private String negativeBtnText;
        // Set it when have a custom content view
        private View contentView;
        // If want custom layout of dialog, please clone file custom_dialog and edit it.
        private int layoutCustom = R.layout.custom_dialog;

        private DialogInterface.OnClickListener positiveBtnClickListener,
                negativeBtnClickListener;

        public Builder(Context context) {
            this.context = context;
        }


        /**
         * Set the Dialog icon from drawable
         *
         * @param icon
         * @return
         */
        public Builder setIcon(@DrawableRes int icon) {
            this.icon = icon;
            return this;
        }

        /**
         * Set the Dialog message from String
         *
         * @param message
         * @return
         */
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * Set the Dialog message from resource
         *
         * @param message
         * @return
         */
        public Builder setMessage(int message) {
            this.message = (String) context.getText(message);
            return this;
        }

        /**
         * Set the Dialog title from resource
         *
         * @param title
         * @return
         */
        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        /**
         * Set the Dialog title from String
         *
         * @param title
         * @return
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Set a custom content view for the Dialog. If a message is set, the
         * contentView is not added to the Dialog...
         *
         * @param contentView
         * @return
         */
        public Builder setContentView(View contentView) {
            this.contentView = contentView;
            return this;
        }

        /**
         * Set the positive button resource and it's listener
         *
         * @param positiveButtonText
         * @param listener
         * @return
         */
        public Builder setPositiveButton(int positiveButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.positiveBtnText = (String) context.getText(positiveButtonText);
            this.positiveBtnClickListener = listener;
            return this;
        }

        /**
         * Set the positive button text and it's listener
         *
         * @param positiveButtonText
         * @param listener
         * @return
         */
        public Builder setPositiveButton(String positiveButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.positiveBtnText = positiveButtonText;
            this.positiveBtnClickListener = listener;
            return this;
        }

        /**
         * Set the positive button resource and it's listener
         *
         * @param negativeButtonText
         * @param listener
         * @return
         */
        public Builder setNegativeButton(int negativeButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.negativeBtnText = (String) context.getText(negativeButtonText);
            this.negativeBtnClickListener = listener;
            return this;
        }

        /**
         * Set the negative button text and it's listener
         *
         * @param negativeButtonText
         * @param listener
         * @return
         */
        public Builder setNegativeButton(String negativeButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.negativeBtnText = negativeButtonText;
            this.negativeBtnClickListener = listener;
            return this;
        }

        public Builder setLayoutCustom(@LayoutRes int layoutCustom) {
            this.layoutCustom = layoutCustom;
            return this;
        }

        /**
         * Create the custom dialog
         */
        public BaseDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // instantiate the dialog
            final BaseDialog dialog = new BaseDialog(context);
            View layout = inflater.inflate(layoutCustom, null);
            dialog.addContentView(layout, new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            // set the dialog icon
            ((ImageView) layout.findViewById(R.id.custom_icon)).setImageResource(icon);

            // set the dialog title
            ((TextView) layout.findViewById(R.id.title)).setText(title);

            // set the confirm button
            if (positiveBtnText != null) {
                ((Button) layout.findViewById(R.id.positive_btn))
                        .setText(positiveBtnText);
                if (positiveBtnClickListener != null) {
                    ((Button) layout.findViewById(R.id.positive_btn))
                            .setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    positiveBtnClickListener.onClick(dialog,
                                            DialogInterface.BUTTON_POSITIVE);
                                }
                            });
                }
            } else {
                // if no confirm button just set the visibility to GONE
                layout.findViewById(R.id.positive_btn).setVisibility(View.GONE);
            }

            // set the cancel button
            if (negativeBtnText != null) {
                ((Button) layout.findViewById(R.id.negative_btn))
                        .setText(negativeBtnText);
                if (negativeBtnClickListener != null) {
                    ((Button) layout.findViewById(R.id.negative_btn))
                            .setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    negativeBtnClickListener.onClick(dialog,
                                            DialogInterface.BUTTON_NEGATIVE);
                                }
                            });
                }
            } else {
                // if no confirm button just set the visibility to GONE
                layout.findViewById(R.id.negative_btn).setVisibility(View.GONE);
            }
            // set the content message
            if (message != null) {
                ((TextView) layout.findViewById(R.id.message)).setText(message);
            } else if (contentView != null) {
                // if no message set
                // add the contentView to the dialog body
                ((LinearLayout) layout.findViewById(R.id.content))
                        .removeAllViews();
                ((LinearLayout) layout.findViewById(R.id.content)).addView(
                        contentView, new LayoutParams(
                                LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT));
            }
            dialog.setContentView(layout);
            return dialog;
        }
    }
}