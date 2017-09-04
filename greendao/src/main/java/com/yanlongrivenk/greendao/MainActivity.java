package com.yanlongrivenk.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.yanlongrivenk.greendao.entity.DaoMaster;
import com.yanlongrivenk.greendao.entity.DaoSession;
import com.yanlongrivenk.greendao.entity.Student;
import com.yanlongrivenk.greendao.entity.StudentDao;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    protected DaoSession mDaoSession;
    protected StudentDao mStuDao;
    @Bind(R.id.rlv)
    RecyclerView mRlv;
    private int index = -1;
    protected GdRecyclerview mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRlv();
        creatDao();
        mStuDao = mDaoSession.getStudentDao();
    }

    private void initRlv() {
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new GdRecyclerview(this, null);
        mRlv.setAdapter(mAdapter);
    }

    private void creatDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "stdent");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDaoSession = daoMaster.newSession();
    }

    @OnClick({R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_4, R.id.bt_5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_1:
                index++;
                Student student = new Student(null, "编号" + index, "名字" + index, "性别" + index, "成绩" + index);
                mStuDao.insert(student);
                queryAll();
                break;
            case R.id.bt_2:
                mStuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("名字" + index)).buildDelete().executeDeleteWithoutDetachingEntities();
                index--;
                queryAll();
                break;
            case R.id.bt_3:
                List<Student> list = mStuDao.queryBuilder().where(StudentDao.Properties.StuName.eq("名字" + index)).list();
                refreshRlv(list);
                break;
            case R.id.bt_4:
                List<Student> students = mStuDao.queryBuilder().list();
                if (students != null && students.size() != 0){
                    Student stu = students.get(0);
                    stu.setStuName("呵呵" + index);
                    mStuDao.update(stu);
                } else {
                    Toast.makeText(this, "没有这条数据", Toast.LENGTH_SHORT).show();
                }
                queryAll();
                break;
            case R.id.bt_5:
                mStuDao.deleteAll();
                break;
        }
    }

    private void queryAll() {
        List<Student> list = mStuDao.queryBuilder().list();
        refreshRlv(list);
    }

    private void refreshRlv(List<Student> list) {
        mAdapter.update(list);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mStuDao.dropTable(mStuDao.getDatabase(), true);
    }
}
