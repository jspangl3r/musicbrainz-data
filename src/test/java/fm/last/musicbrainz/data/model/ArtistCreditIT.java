/*
 * Copyright 2013 The musicbrainz-data Authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package fm.last.musicbrainz.data.model;

import static org.hamcrest.CoreMatchers.is;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

import fm.last.musicbrainz.data.AbstractHibernateModelIT;

public class ArtistCreditIT extends AbstractHibernateModelIT {

  @Test
  public void fullNameIsOrderedByPosition() {
    String expected = "Mono and Rick Astley feat. Hot Chip";
    ArtistCredit artistCredit = (ArtistCredit) session.load(ArtistCredit.class, 3);
    assertThat(artistCredit.getFullName(), is(expected));
  }

  @Test
  public void singleArtistArtistCreditHasSameFullNameAsArtist() {
    ArtistCredit artistCredit = (ArtistCredit) session.load(ArtistCredit.class, 1);
    Artist artist = artistCredit.getArtistCreditNames().iterator().next().getArtist();
    assertThat(artistCredit.getFullName(), is(artist.getName()));
  }

  @Test
  public void artistCreditNameReferenceDoesNotHitDatabase() {
    ArtistCredit artistCredit = (ArtistCredit) session.load(ArtistCredit.class, 1);
    List<ArtistCreditName> artistCreditNames = artistCredit.getArtistCreditNames();
    assertThat(fetchCount(), is(1L));
  }

}
