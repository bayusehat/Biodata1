package id.sch.smktelkom_mlg.tugas01.xirpl1007.biodata1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etTGL;
    TextView tvHasil;
    TextView tvLahir;
    TextView tvStatus;
    TextView tvHobi;
    TextView tvWilayah;
    Button bOK;
    RadioGroup rgsts;
    CheckBox cbf, cbb, cbv, cbl;
    Spinner spprov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.edittextnama);
        etTGL = (EditText) findViewById(R.id.editexttgl);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.tvHasil);
        tvLahir = (TextView) findViewById(R.id.tvLahir);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
        tvHobi = (TextView) findViewById(R.id.tvHobi);
        tvWilayah = (TextView) findViewById(R.id.tvWilayah);
        rgsts = (RadioGroup) findViewById(R.id.RadioGroup);
        cbf = (CheckBox) findViewById(R.id.cbf);
        cbb = (CheckBox) findViewById(R.id.cbb);
        cbv = (CheckBox) findViewById(R.id.cbv);
        cbl = (CheckBox) findViewById(R.id.cbl);
        spprov = (Spinner) findViewById(R.id.spinnerprovinsi);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProclick();
            }
        });
    }

    private void doProclick() {
        if (kuiValid()) {
            String nama = etNama.getText().toString();
            String tgl = etTGL.getText().toString();
            tvHasil.setText("Nama:" + nama + "\nTanggal Lahir:" + tgl);
        }
        String hasil = null;
        if (rgsts.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgsts.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (hasil == null) {
            tvStatus.setError("Anda belum memlilih status");
        } else {
            tvStatus.setText("Status:" + hasil);
        }
        String hasilcb = "Hobi anda:\n";
        int startlen = hasilcb.length();
        if (cbf.isChecked()) hasilcb += cbf.getText() + "\n";
        if (cbb.isChecked()) hasilcb += cbb.getText() + "\n";
        if (cbv.isChecked()) hasilcb += cbv.getText() + "\n";
        if (cbl.isChecked()) hasilcb += cbl.getText() + "\n";

        if (hasilcb.length() == startlen) hasil += "Tidak ada pada pilihan";

        tvHobi.setText(hasilcb);

        tvWilayah.setText("Wilayah Provinsi:" + spprov.getSelectedItem().toString());
    }


    private boolean kuiValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tgl = etTGL.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Anda Belum Mengisi Nama");
            valid = false;
        } else if (nama.length() < 8) {
            etNama.setError("Nama harus kurang dari 8 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (tgl.isEmpty()) {
            etTGL.setError("Anda belum mengisi tanggal lahir");
            valid = false;
        } else {
            etTGL.setError(null);
        }
        return valid;

    }
}
