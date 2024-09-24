package com.projetoAquitetura;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.projetoAquitetura.model.HistoricoStatus;
import com.projetoAquitetura.model.Projeto;
import com.projetoAquitetura.service.ApiService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelaProjetoActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://192.168.1.2:8080/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaprojeto);

        long projetoId = getIntent().getLongExtra("PROJETO_ID", 11);

        if (projetoId != -1) {
            buscarProjeto(projetoId);
            buscarHistorico(projetoId);
        } else {
            Toast.makeText(this, "ID de projeto inválido", Toast.LENGTH_SHORT).show();
            finish(); // Encerra a atividade se o ID for inválido
        }
    }

    private void buscarHistorico(long projetoId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getHistorico(projetoId).enqueue(new Callback<List<HistoricoStatus>>() {
            @Override
            public void onResponse(Call<List<HistoricoStatus>> call, Response<List<HistoricoStatus>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<HistoricoStatus> historico = response.body();
                    LinearLayout historicoLayout = findViewById(R.id.historicoLayout);
                    historicoLayout.removeAllViews(); // Limpar visualizações existentes

                    for (HistoricoStatus status : historico) {
                        View statusView = getLayoutInflater().inflate(R.layout.item_historico, null);
                        TextView tvEtapaProjeto = statusView.findViewById(R.id.tvEtapaProjetoLabel);
                        TextView tvDtcEtapaProjeto = statusView.findViewById(R.id.tvDtcEtapaProjeto);
                        TextView tvUsuarioEdit = statusView.findViewById(R.id.tvUsuarioEdit);

                        tvEtapaProjeto.setText(status.getEtapa());
                        tvDtcEtapaProjeto.setText(status.getData());
                        tvUsuarioEdit.setText(status.getFuncionario());

                        historicoLayout.addView(statusView);
                    }
                } else {
                    Toast.makeText(TelaProjetoActivity.this, "Histórico não encontrado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<HistoricoStatus>> call, Throwable t) {
                Toast.makeText(TelaProjetoActivity.this, "Erro ao buscar histórico: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void buscarProjeto(long projetoId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getProjeto(projetoId).enqueue(new Callback<Projeto>() {
            @Override
            public void onResponse(Call<Projeto> call, Response<Projeto> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Projeto projeto = response.body();

                    // Popular as informações na UI
                    TextView tvNomeCliente = findViewById(R.id.tvNomeCliente);
                    tvNomeCliente.setText(projeto.getNomcliente());

                    TextView tvTipoProjeto = findViewById(R.id.tvTipoProjeto);
                    tvTipoProjeto.setText(projeto.getDestipo());

                    TextView tvItensLayout = findViewById(R.id.tvItensLayout);
                    tvItensLayout.setText(projeto.getDesitens());

                    TextView tvDataInicio = findViewById(R.id.tvDataInicio);
                    tvDataInicio.setText(projeto.getDtcinicioFormatada());
                } else {
                    Toast.makeText(TelaProjetoActivity.this, "Projeto não encontrado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Projeto> call, Throwable t) {
                Toast.makeText(TelaProjetoActivity.this, "Erro ao buscar projeto: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
