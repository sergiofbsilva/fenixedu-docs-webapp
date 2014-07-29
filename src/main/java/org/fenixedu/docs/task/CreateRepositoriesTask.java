package org.fenixedu.docs.task;

import java.util.Locale;

import org.fenixedu.bennu.core.domain.User;
import org.fenixedu.bennu.core.domain.UserProfile;
import org.fenixedu.bennu.core.groups.AnyoneGroup;
import org.fenixedu.bennu.core.groups.LoggedGroup;
import org.fenixedu.bennu.core.groups.UserGroup;
import org.fenixedu.bennu.scheduler.custom.CustomTask;
import org.fenixedu.docs.domain.DirNode;

public class CreateRepositoriesTask extends CustomTask {

    @Override
    public void runTask() throws Exception {

        User rita = getUser("rita");
        User sergio = getUser("sergio");
        User sandro = getUser("sandro");
        User joao = getUser("joao");

        DirNode repoMtaForte = new DirNode("Sala muita forte", UserGroup.of(sergio, sandro, joao, rita));

        rita.addRepository(repoMtaForte);
        sergio.addRepository(repoMtaForte);
        sandro.addRepository(repoMtaForte);
        joao.addRepository(repoMtaForte);

        User tiago = getUser("tiago");
        User joana = getUser("joana");

        DirNode repoSalaBoss = new DirNode("Sala boss", UserGroup.of(tiago, joana));

        tiago.addRepository(repoSalaBoss);
        joana.addRepository(repoSalaBoss);

        DirNode repoIST = new DirNode("Instituto Superior Técnico", LoggedGroup.get());

        DirNode publico = new DirNode("Público", AnyoneGroup.get());

    }

    private User getUser(String username) {
        User userBoss = User.findByUsername(username);
        if (userBoss == null) {
            userBoss =
                    new User(username, new UserProfile(username, username, username, username + "@docs.eu", Locale.getDefault()));
        }
        return userBoss;
    }
}