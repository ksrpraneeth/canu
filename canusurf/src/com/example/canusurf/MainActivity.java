package com.example.canusurf;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseGameActivity implements
		android.view.View.OnClickListener {
	SignInButton SignIn;
	Button SignOut;
	Button GetAchievement;
	Button ShowAchievement;
	Button Submitscore;
	Button leaderboard;
	int i = 1;

	@Override
	protected void onCreate(Bundle b) {
		// TODO Auto-generated method stub
		super.onCreate(b);
		setContentView(R.layout.activity_main);

		SignIn = (SignInButton) findViewById(R.id.sign_in_button);
		SignOut = (Button) findViewById(R.id.sign_out_button);
		GetAchievement = (Button) findViewById(R.id.getachievement);
		Submitscore = (Button) findViewById(R.id.submitscore);
		ShowAchievement = (Button) findViewById(R.id.showachievement);
		leaderboard = (Button) findViewById(R.id.showleaderboard);
		SignIn.setOnClickListener(this);
		SignOut.setOnClickListener(this);
		GetAchievement.setOnClickListener(this);
		ShowAchievement.setOnClickListener(this);
		Submitscore.setOnClickListener(this);
		leaderboard.setOnClickListener(this);
	}

	@Override
	public void onSignInFailed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSignInSucceeded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.sign_in_button:
			beginUserInitiatedSignIn();
			break;
		case R.id.sign_out_button:
			signOut();
			break;
		case R.id.getachievement:
			if (getApiClient().isConnected())
				Games.Achievements.unlock(getApiClient(),
						getString(R.string.clicked_correctly));
			break;
		case R.id.showachievement:
			startActivityForResult(
					Games.Achievements.getAchievementsIntent(getApiClient()), 1);
			break;
		case R.id.submitscore:
			i++;
			Games.Leaderboards.submitScore(getApiClient(),
					getString(R.string.top_rankings), 10 + i);
			break;
		case R.id.showleaderboard:
			startActivityForResult(Games.Leaderboards.getLeaderboardIntent(
					getApiClient(), getString(R.string.top_rankings)), 2);
			break;
		default:
			break;
		}
	}
}
