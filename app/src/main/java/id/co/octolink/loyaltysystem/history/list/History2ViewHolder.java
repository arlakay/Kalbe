package id.co.octolink.loyaltysystem.history.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import id.co.octolink.R;
import id.co.octolink.model.History;

/**
 * Created by FirdaRinoa on 8/22/16.
 */
public class History2ViewHolder extends RecyclerView.ViewHolder{
    TextView namaStore;
    TextView alamatStore;
    TextView dateTransactStore;

    public History2ViewHolder(View itemView) {
        super(itemView);

        namaStore = (TextView) itemView.findViewById(R.id.merchantname_history2);
        alamatStore = (TextView) itemView.findViewById(R.id.merchantaddress_history2);
        dateTransactStore = (TextView) itemView.findViewById(R.id.merchantdate_history2);

    }

    public void bind(final History model, final History2Adapter.OnItemClickListener listener) {
        namaStore.setText( model.getStore_name());
//        alamatStore.setText( model.getTerminal_code());
        dateTransactStore.setText( model.getTransaction_date());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(model);

            }
        });
    }
}
