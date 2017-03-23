<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <MetaData>
            <Sequence>
                <Title>
                    <ProperTitle>
                        <xsl:value-of select="MetaData.Sequence.Title.ProperTitle"/>
                    </ProperTitle>
                    <ParallelProperTitle>
                        <xsl:value-of select="MetaData.Sequence.Title.ParallelProperTitle"/>
                    </ParallelProperTitle>
                    <SeriesTitle>
                        <xsl:value-of select="MetaData.Sequence.Title.SeriesTitle"/>
                    </SeriesTitle>
                </Title>
                <Subject>
                    <Class>
                        <Classification>
                            <xsl:value-of select="MetaData.Sequence.Subject.Class.ClassNumber"/>
                        </Classification>
                        <ClassNumber>
                            <xsl:value-of select="MetaData.Sequence.Subject.Class.ClassNumber"/>
                        </ClassNumber>
                    </Class>
                    <SubjectTerm>
                        <xsl:value-of select="MetaData.Sequence.Subject.SubjectTerm"/>
                    </SubjectTerm>
                    <Keyword>
                        <xsl:value-of select="MetaData.Sequence.Subject.Keyword"/>
                    </Keyword>
                </Subject>
                <Description>
                    <DescriptionofContent>
                        <xsl:value-of select="MetaData.Sequence.Description.DescriptionofContent"/>
                    </DescriptionofContent>
                    <DateofEvent>
                        <xsl:value-of select="MetaData.Sequence.Description.DateofEvent"/>
                    </DateofEvent>
                    <Awards>
                        <NameofAwards>
                            <xsl:value-of select="MetaData.Sequence.Description.Awards.NameofAwards"/>
                        </NameofAwards>
                        <ItemofAwards>
                            <xsl:value-of select="MetaData.Sequence.Description.Awards.ItemofAwards"/>
                        </ItemofAwards>
                        <WinnersofAwards>
                            <xsl:value-of select="MetaData.Sequence.Description.Awards.WinnersofAwards"/>
                        </WinnersofAwards>
                        <YearorTimeofAwards>
                            <xsl:value-of select="MetaData.Sequence.Description.Awards.YearorTimeofAwards"/>
                        </YearorTimeofAwards>
                        <DateofAwards>
                            <xsl:value-of select="MetaData.Sequence.Description.Awards.DateofAwards"/>
                        </DateofAwards>
                    </Awards>
                    <NaturalSound>
                        <xsl:value-of select="MetaData.Sequence.Description.NaturalSound"/>
                    </NaturalSound>
                </Description>
                <Creator>
                    <DescriptionofCreator>
                        <NameofCreator>
                            <xsl:value-of select="MetaData.Sequence.Creator.DescriptionofCreator.NameofCreator"/>
                        </NameofCreator>
                        <ParallelNameofCreator>
                            <xsl:value-of select="MetaData.Sequence.Creator.DescriptionofCreator.ParallelNameofCreator"/>
                        </ParallelNameofCreator>
                        <Role>
                            <xsl:value-of select="MetaData.Sequence.Creator.DescriptionofCreator.Role"/>
                        </Role>
                        <OtherInformation>
                            <xsl:value-of select="MetaData.Sequence.Creator.DescriptionofCreator.OtherInformation"/>
                        </OtherInformation>
                    </DescriptionofCreator>
                </Creator>
                <Contributor>
                    <DescriptionofContributor>
                        <NameofContributor>
                            <xsl:value-of select="MetaData.Sequence.Contributor.DescriptionofContributor.NameofContributor"/>
                        </NameofContributor>
                        <ParallelNameofContributor>
                            <xsl:value-of select="MetaData.Sequence.Contributor.DescriptionofContributor.ParallelNameofContributor"/>
                        </ParallelNameofContributor>
                        <Role>
                            <xsl:value-of select="MetaData.Sequence.Contributor.DescriptionofContributor.Role"/>
                        </Role>
                        <OtherInformation>
                            <xsl:value-of select="MetaData.Sequence.Contributor.DescriptionofContributor.OtherInformation"/>
                        </OtherInformation>
                    </DescriptionofContributor>
                </Contributor>
                <Copyright>
                    <DescriptionofAuthorizedUse>
                        <TimesofAuthorizedUsage>
                            <xsl:value-of select="MetaData.Sequence.Copyright.DescriptionofAuthorizedUse.TimesofAuthorizedUsage"/>
                        </TimesofAuthorizedUsage>
                    </DescriptionofAuthorizedUse>
                </Copyright>
                <Language>
                    <AudioChannel>
                        <AudioChannelNumber>
                            <xsl:value-of select="MetaData.Sequence.Language.AudioChannel.AudioChannelNumber"/>
                        </AudioChannelNumber>
                        <AudioChannelLanguage>
                            <xsl:value-of select="MetaData.Sequence.Language.AudioChannel.AudioChannelLanguage"/>
                        </AudioChannelLanguage>
                    </AudioChannel>

                    <Subtitle>
                        <SubtitleNumber>
                            <xsl:value-of select="MetaData.Sequence.Language.Subtitle.SubtitleNumber"/>
                        </SubtitleNumber>
                        <SubtitleLanguage>
                            <xsl:value-of select="MetaData.Sequence.Language.Subtitle.SubtitleLanguage"/>
                        </SubtitleLanguage>
                    </Subtitle>
                </Language>
                <Type>
                    <ProgramForm>
                        <xsl:value-of select="MetaData.Sequence.Type.ProgramForm"/>
                    </ProgramForm>
                </Type>
                <Format>
                    <Duration>
                        <xsl:value-of select="CMS/MetaData/Clip/ClipBaseInfo/Duration"/>
                    </Duration>
                    <StartingPoint>
                        <xsl:value-of select="MetaData.Sequence.Format.StartingPoint"/>
                    </StartingPoint>
                    <SubtitleForm>
                        <xsl:value-of select="MetaData.Sequence.Format.SubtitleForm"/>
                    </SubtitleForm>
                </Format>
                <Coverage>
                    <YearofStart>
                        <xsl:value-of select="MetaData.Sequence.Coverage.YearofStart"/>
                    </YearofStart>
                    <YearofEnd>
                        <xsl:value-of select="MetaData.Sequence.Coverage.YearofEnd"/>
                    </YearofEnd>
                    <DescriptionofYearsCovered>
                        <xsl:value-of select="MetaData.Sequence.Coverage.DescriptionofYearsCovered"/>
                    </DescriptionofYearsCovered>
                        <Spatial>
                            <xsl:value-of select="MetaData.Sequence.Coverage.Spatial"/>
                        </Spatial>
                </Coverage>
                <Source>
                    <SourceAcquiredMethod>
                        <xsl:value-of select="MetaData.Sequence.Source.SourceAcquiredMethod"/>
                    </SourceAcquiredMethod>
                    <SourceProvider>
                        <xsl:value-of select="MetaData.Sequence.Source.SourceProvider"/>
                    </SourceProvider>
                </Source>
                <Relation>
                    <IsPartof>
                        <xsl:value-of select="MetaData.Sequence.Relation.IsPartof"/>
                    </IsPartof>
                    <References>
                        <xsl:value-of select="MetaData.Sequence.Relation.References"/>
                    </References>
                </Relation>
            </Sequence>
        </MetaData>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>