package com.collaboration.dao;

import java.util.List;

import com.collaboration.model.Friend;
import com.collaboration.model.UserDetail;

public interface FriendDAO {

public Friend getFriend(int friendid);
public List<Friend> showFriendList(String username);
public List<Friend> showPendingFriendRequest(String username);
public List<UserDetail> showSuggestedFriends(String username);
public boolean sendFriendRequest(Friend friend);
public boolean acceptFriendRequest(Friend friend);
public boolean deleteFriendRequest(Friend friend);
}
