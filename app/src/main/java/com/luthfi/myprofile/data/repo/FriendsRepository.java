package com.luthfi.myprofile.data.repo;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import com.luthfi.myprofile.data.db.AppDatabase;
import com.luthfi.myprofile.data.db.FriendsDao;
import com.luthfi.myprofile.data.model.Friends;
import java.util.List;

// 02-08-2019 Luthfi Alfarisi 10116365 IF-8

public class FriendsRepository {
    private FriendsDao friendsDao;
    private LiveData<List<Friends>> friendsList;

    public FriendsRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        friendsDao = db.friendsDao();
        friendsList = friendsDao.getAll();
    }

    public LiveData<List<Friends>> getAllFriends() {
        return friendsList;
    }

    public void insertFriend(Friends friends) {
        new insertAsync(friendsDao).execute(friends);
    }

    public void updateFriend(Friends friends) {
        new updateAsync(friendsDao).execute(friends);
    }

    public void deleteFriend(Friends friends) {
        new deleteAsync(friendsDao).execute(friends);
    }

    private static class insertAsync extends AsyncTask<Friends, Void, Void> {
        private FriendsDao friendsDao;

        insertAsync(FriendsDao friendsDao) {
            this.friendsDao = friendsDao;
        }

        @Override
        protected Void doInBackground(Friends... friends) {
            friendsDao.addFriend(friends);
            return null;
        }
    }

    private static class updateAsync extends AsyncTask<Friends, Void, Void> {
        private FriendsDao friendsDao;

        updateAsync(FriendsDao friendsDao) {
            this.friendsDao = friendsDao;
        }

        @Override
        protected Void doInBackground(Friends... friends) {
            friendsDao.updateFriend(friends);
            return null;
        }
    }

    private static class deleteAsync extends AsyncTask<Friends, Void, Void> {
        private FriendsDao friendsDao;

        deleteAsync(FriendsDao friendsDao) {
            this.friendsDao = friendsDao;
        }

        @Override
        protected Void doInBackground(Friends... friends) {
            friendsDao.deleteFriend(friends);
            return null;
        }
    }
}
