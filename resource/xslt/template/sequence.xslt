<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <MetaData>
            <xsl:for-each select="MetaData.Sequence">
                <Sequence>
                    <Title>
                        <ProperTitle>
                            <xsl:value-of select="MetaData.Sequence.Title.ProperTitle"/>
                        </ProperTitle>
                        <xsl:for-each select="MetaData.Sequence.Title.ParallelProperTitle">
                            <ParallelProperTitle>
                                <xsl:value-of select="current()"/>
                            </ParallelProperTitle>
                        </xsl:for-each>
                        <SeriesTitle>
                            <xsl:value-of select="MetaData.Sequence.Title.SeriesTitle"/>
                        </SeriesTitle>
                    </Title>
                    <Subject>
                        <xsl:for-each select="MetaData.Sequence.Subject.Class">
                            <Class>
                                <Classification>
                                    <xsl:value-of select="MetaData.Sequence.Subject.Class.Classification"/>
                                </Classification>
                                <ClassNumber>
                                    <xsl:value-of select="MetaData.Sequence.Subject.Class.ClassNumber"/>
                                </ClassNumber>
                            </Class>
                        </xsl:for-each>
                        <xsl:for-each select="MetaData.Sequence.Subject.SubjectTerm">
                            <SubjectTerm>
                                <xsl:value-of select="current()"/>
                            </SubjectTerm>
                        </xsl:for-each>
                        <xsl:for-each select="MetaData.Sequence.Subject.Keyword">
                            <Keyword>
                                <xsl:value-of select="current()"/>
                            </Keyword>
                        </xsl:for-each>
                    </Subject>
                    <Description>
                        <DescriptionofContent>
                            <xsl:value-of select="MetaData.Sequence.Description.DescriptionofContent"/>
                        </DescriptionofContent>
                        <DateofEvent>
                            <xsl:value-of select="MetaData.Sequence.Description.DateofEvent"/>
                        </DateofEvent>
                        <xsl:for-each select="MetaData.Sequence.Description.Awards">
                            <Awards>
                                <NameofAwards>
                                    <xsl:value-of select="MetaData.Sequence.Description.Awards.NameofAwards"/>
                                </NameofAwards>
                                <ItemofAwards>
                                    <xsl:value-of select="MetaData.Sequence.Description.Awards.ItemofAwards"/>
                                </ItemofAwards>
                                <xsl:for-each select="MetaData.Sequence.Description.Awards.WinnersofAwards">
                                    <WinnersofAwards>
                                        <xsl:value-of select="current()"/>
                                    </WinnersofAwards>
                                </xsl:for-each>
                                <YearorTimeofAwards>
                                    <xsl:value-of select="MetaData.Sequence.Description.Awards.YearorTimeofAwards"/>
                                </YearorTimeofAwards>
                                <DateofAwards>
                                    <xsl:value-of select="MetaData.Sequence.Description.Awards.DateofAwards"/>
                                </DateofAwards>
                            </Awards>
                        </xsl:for-each>
                        <NaturalSound>
                            <xsl:value-of select="MetaData.Sequence.Description.NaturalSound"/>
                        </NaturalSound>
                    </Description>
                    <Creator>
                        <xsl:for-each select="MetaData.Sequence.Creator.DescriptionofCreator">
                            <DescriptionofCreator>
                                <NameofCreator>
                                    <xsl:value-of select="MetaData.Sequence.Creator.DescriptionofCreator.NameofCreator"/>
                                </NameofCreator>
                                <xsl:for-each select="MetaData.Sequence.Creator.DescriptionofCreator.ParallelNameofCreator">
                                    <ParallelNameofCreator>
                                        <xsl:value-of select="current()"/>
                                    </ParallelNameofCreator>
                                </xsl:for-each>
                                <Role>
                                    <xsl:value-of select="MetaData.Sequence.Creator.DescriptionofCreator.Role"/>
                                </Role>
                                <OtherInformation>
                                    <xsl:value-of select="MetaData.Sequence.Creator.DescriptionofCreator.OtherInformation"/>
                                </OtherInformation>
                            </DescriptionofCreator>
                        </xsl:for-each>
                    </Creator>
                    <Contributor>
                        <xsl:for-each select="MetaData.Sequence.Contributor.DescriptionofContributor">
                            <DescriptionofContributor>
                                <NameofContributor>
                                    <xsl:value-of select="MetaData.Sequence.Contributor.DescriptionofContributor.NameofContributor"/>
                                </NameofContributor>
                                <xsl:for-each select="MetaData.Sequence.Contributor.DescriptionofContributor.ParallelNameofContributor">
                                    <ParallelNameofContributor>
                                        <xsl:value-of select="current()"/>
                                    </ParallelNameofContributor>
                                </xsl:for-each>
                                <Role>
                                    <xsl:value-of select="MetaData.Sequence.Contributor.DescriptionofContributor.Role"/>
                                </Role>
                                <OtherInformation>
                                    <xsl:value-of select="MetaData.Sequence.Contributor.DescriptionofContributor.OtherInformation"/>
                                </OtherInformation>
                            </DescriptionofContributor>
                        </xsl:for-each>
                    </Contributor>

                    <Publisher>
                        <xsl:for-each select="MetaData.Sequence.Publisher.DescriptionofPublisher">
                            <DescriptionofPublisher>
                                <NameofPublisher>
                                    <xsl:value-of select="MetaData.Sequence.Publisher.DescriptionofPublisher.NameofPublisher"/>
                                </NameofPublisher>
                                <PlaceofPublication>
                                    <xsl:value-of select="MetaData.Sequence.Publisher.DescriptionofPublisher.PlaceofPublication"/>
                                </PlaceofPublication>
                            </DescriptionofPublisher>
                        </xsl:for-each>
                        <xsl:for-each select="MetaData.Sequence.Publisher.DescriptionofProducer">
                            <DescriptionofProducer>
                                <NameofProducer>
                                    <xsl:value-of select="MetaData.Sequence.Publisher.DescriptionofProducer.NameofProducer"/>
                                </NameofProducer>
                                <PlaceofProduction>
                                    <xsl:value-of select="MetaData.Sequence.Publisher.DescriptionofProducer.PlaceofProduction"/>
                                </PlaceofProduction>
                            </DescriptionofProducer>
                        </xsl:for-each>
                    </Publisher>
                    <Copyright>
                        <xsl:for-each select="MetaData.Sequence.Copyright.DescriptionofAuthorizedUse">
                            <DescriptionofAuthorizedUse>
                                <TimesofAuthorizedUsage>
                                    <xsl:value-of select="MetaData.Sequence.Copyright.DescriptionofAuthorizedUse.TimesofAuthorizedUsage"/>
                                </TimesofAuthorizedUsage>
                            </DescriptionofAuthorizedUse>
                        </xsl:for-each>
                    </Copyright>
                    <Language>
                        <xsl:for-each select="MetaData.Sequence.Language.AudioChannel">
                            <AudioChannel>
                                <AudioChannelNumber>
                                    <xsl:value-of select="MetaData.Sequence.Language.AudioChannel.AudioChannelNumber"/>
                                </AudioChannelNumber>
                                <AudioChannelLanguage>
                                    <xsl:value-of select="MetaData.Sequence.Language.AudioChannel.AudioChannelLanguage"/>
                                </AudioChannelLanguage>
                            </AudioChannel>
                        </xsl:for-each>
                        <xsl:for-each select="MetaData.Sequence.Language.Subtitle">
                            <Subtitle>
                                <SubtitleNumber>
                                    <xsl:value-of select="MetaData.Sequence.Language.Subtitle.SubtitleNumber"/>
                                </SubtitleNumber>
                                <SubtitleLanguage>
                                    <xsl:value-of select="MetaData.Sequence.Language.Subtitle.SubtitleLanguage"/>
                                </SubtitleLanguage>
                            </Subtitle>
                        </xsl:for-each>
                    </Language>
                    <Type>
                        <xsl:for-each select="MetaData.Sequence.Type.ProgramForm">
                            <ProgramForm>
                                <xsl:value-of select="current()"/>
                            </ProgramForm>
                        </xsl:for-each>
                    </Type>
                    <Format>
                        <Duration>
                            <xsl:value-of select="MetaData.Sequence.Format.Duration"/>
                        </Duration>
                        <StartingPoint>
                            <xsl:value-of select="MetaData.Sequence.Format.StartingPoint"/>
                        </StartingPoint>
                        <SubtitleForm>
                            <xsl:value-of select="MetaData.Sequence.Format.SubtitleForm"/>
                        </SubtitleForm>
                    </Format>
                    <Coverage>
                        <xsl:for-each select="MetaData.Sequence.Coverage.YearofStart">
                            <YearofStart>
                                <xsl:value-of select="current()"/>
                            </YearofStart>
                            <YearofEnd>
                                <xsl:value-of select="current()"/>
                            </YearofEnd>
                            <DescriptionofYearsCovered>
                                <xsl:value-of select="current()"/>
                            </DescriptionofYearsCovered>
                        </xsl:for-each>
                        <xsl:for-each select="MetaData.Sequence.Coverage.Spatial">
                            <Spatial>
                                <xsl:value-of select="current()"/>
                            </Spatial>
                        </xsl:for-each>
                    </Coverage>
                </Sequence>
            </xsl:for-each>
        </MetaData>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>