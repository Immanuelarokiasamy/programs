var myApp=angular.module("myApp",['ngRoute','ngCookies']);

myApp.config(function($routeProvider) {
	
	$routeProvider.when("/login",{templateUrl:"c_user/Login.html"})
                  .when("/register",{templateUrl:"c_user/Register.html"})
                  .when("/userHome",{templateUrl:"c_user/UserHome.html"})
                  .when("/profile",{templateUrl:"c_user/ProfilePicture.html"})
                  .when("/chat",{templateUrl:"c_chat/Chat.html"})
	             
                  .when("/addBlog",{templateUrl:"c_blog/AddBlog.html"})
                  .when("/manageBlog",{templateUrl:"c_blog/ManageBlog.html"})
                  .when("/showBlog",{templateUrl:"c_blog/ShowBlog.html"})
                  .when("/updateBlog",{templateUrl:"c_blog/UpdateBlog.html"})
                  .when("/myBlog",{templateUrl:"c_blog/MyBlog.html"})
                  
	             
                  .when("/blogComment",{templateUrl:"c_blog/BlogComment.html"})
                  .when("/updateBlogComment",{templateUrl:"c_blog/UpdateBlogComment.html"})
	             
	              .when("/addForum",{templateUrl:"c_forum/AddForum.html"})
                  .when("/manageForum",{templateUrl:"c_forum/ManageForum.html"})
                  .when("/showForum",{templateUrl:"c_forum/ShowForum.html"})
                  .when("/updateForum",{templateUrl:"c_forum/UpdateForum.html"})
                  .when("/myForum",{templateUrl:"c_forum/MyForum.html"})
	              
	              .when("/forumComment",{templateUrl:"c_forum/ForumComment.html"})
	              .when("/updateForumComment",{templateUrl:"c_forum/UpdateForumComment.html"})
	              
	              .when("/addJob",{templateUrl:"c_job/AddJob.html"})
	              .when("/showJob",{templateUrl:"c_job/ShowJob.html"})
	              
	              .when("/showFriends",{templateUrl:"c_friend/ShowFriends.html"})
	              .when("/friendRequests",{templateUrl:"c_friend/FriendRequests.html"})
	              .when("/suggestedFriends",{templateUrl:"c_friend/SuggestedFriends.html"})
	              
	              .when("/contactus",{templateUrl:"c_view/ContactUs.html"})
	              .when("/aboutus",{templateUrl:"c_view/AboutUs.html"});
	
});
	              
myApp.run(function($rootScope,$cookieStore)
{
console.log("I am in run function");
if($rootScope.currentUser==undefined)
	{
	$rootScope.currentUser=$cookieStore.get('userDetail');
	}
});
